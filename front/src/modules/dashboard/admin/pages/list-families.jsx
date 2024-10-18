import { useEffect, useState } from 'react';
import { AppLayout } from '@/layouts/app-layout';
import { useNavigate } from 'react-router-dom';
import { useMutation, useQuery } from '@tanstack/react-query';
import { getAllFamiliesApi, searchFamiliesApi } from '../api';
import { toast } from 'react-toastify';
import Familia from '../components/familia';
import {
  Form,
  Input,
  Pagination,
  PaginationContent,
  PaginationItem,
  PaginationNext,
  PaginationPrevious,
} from '@/components/ui';
import { useForm } from 'react-hook-form';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

export default function ListFamilies() {
  const [currentFamilies, setCurrentFamilies] = useState(null);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5;
  const [family, setFamily] = useState(null);
  const navigate = useNavigate();
  const schema = yup.object({
    nombre: yup
      .string()
      .required('Introduce un nombre valido')
      .min(3, 'Un nombre no puede tener menos de 3 letras')
      .max(50, 'Un nombre no puede tener más que 50 letras')
      .matches(
        /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/,
        'Un nombre solo puede tener letras'
      ),
  });
  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      nombre: ''
    }
  });
  const { data, isLoading } = useQuery({
    queryKey: ['families'],
    queryFn: getAllFamiliesApi,
    staleTime: 5 * 60 * 1000, // data is fresh for 5 minutes
    cacheTime: 10 * 60 * 1000, // cache lasts for 10 minutes
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });

  const handlePreviousPage = () => {
    if (currentPage > 1) {
      setCurrentPage(currentPage - 1);
    }
  };

  const handleNextPage = () => {
    if (currentPage < Math.ceil(data.length / itemsPerPage)) {
      setCurrentPage(currentPage + 1);
    }
  };

  useEffect(() => {
    if (data && data.length > 0) {
      const startIndex = (currentPage - 1) * itemsPerPage;
      const endIndex = startIndex + itemsPerPage;
      setCurrentFamilies(data.slice(startIndex, endIndex));
    } else {
      setCurrentFamilies([]);
    }
  }, [data, currentPage]);
  const mutation = useMutation({
    mutationFn: searchFamiliesApi,
    onSuccess: (data) => {
      if (data?.length > 0) {
        setFamily(data);
      } else {
        toast.success('No hay alguien con este nombre');
      }
    },
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  const onSubmit = async (data) => {
    mutation.mutate(data);
  };

  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid'>
        <div className='transition-all duration-300 ease-in-out p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:mt-[10vh] md:h-fit md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex flex-col gap-4'>
            <div className='flex md:flex-col gap-2 md:gap-5'>
              <img
                onClick={() => navigate('/admin/dashboard')}
                src='/common/arrow-left.svg'
                alt='Regresar a la página principal'
                className='self-start pt-2 md:pt-0 hover:cursor-pointer'
              />
              <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>
                Listado de Familias
              </p>
            </div>
            {!isLoading && data?.length !== 0 && (<>
              <Form {...form}>
                <form onSubmit={form.handleSubmit(onSubmit)}>
                  <div className='relative my-3'>
                    <Input
                      name='nombre'
                      placeholder={'Busca por nombre'}
                      className='rounded-3xl bg-neutral-200 placeholder:text-emerald-500 py-4 px-12 focus-visible:ring-0 focus-visible:ring-offset-0'
                      {...form.register('nombre', { required: true })}
                    />
                    <img src='/common/search.svg' alt='buscar familia' className=' absolute top-2 left-4'/>
                    <button type='submit' className={`${family ? 'hidden' : 'block'} text-sm absolute top-[0px] right-0 bg-green hover:bg-greenHover text-gray-100  rounded-r-full px-4 h-10 flex items-center justify-center`}>Buscar</button>
                    <button className={`absolute top-2 right-4 ${family ? 'block' : 'hidden'}`} onClick={() => {
                      setFamily(null);
                      form.clearErrors();
                      form.reset();
                    }}><img src='/common/close-circle.svg' alt='borrar el buscador' /></button>
                  </div>
                </form>
              </Form>
            </>)}
          </div>
          {isLoading && (
            <div className='grid justify-center items-center mt-12'>
              <div className='animate-spin rounded-full h-12 w-12 border-b-2 border-gray-400'></div>
            </div>
          )}
          {!isLoading && family && <>
            {family &&
                family?.map((familia) => (
                  <div className='animate-fade-in' key={familia.id}>
                    <Familia
                      usuario={familia?.nombreFaUno}
                      id={familia.id}
                      nombreFaUno={familia?.nombreFaUno}
                    />
                  </div>
                ))}
          </>}
          {!isLoading && !family && data?.length !== 0 && (
            <>
              {currentFamilies &&
                currentFamilies?.map((familia) => (
                  <Familia
                    key={familia.id}
                    usuario={familia.usuario}
                    id={familia.id}
                    nombreFaUno={familia.nombreFaUno}
                  />
                ))}
            </>
          )}
          {!isLoading && !family && data?.length !== 0 && (
            <Pagination>
              <PaginationContent className='flex justify-between w-full'>
                <PaginationItem
                  className={`hover:cursor-pointer ${currentPage === 1 ? 'text-gray-200 hover:text-gray-200' : ''}`}
                >
                  <PaginationPrevious
                    className={`${
                      currentPage === 1 ? 'hover:bg-transparent hover:text-gray-200 hover:cursor-not-allowed' : undefined
                    }`}
                    onClick={handlePreviousPage}
                  />
                </PaginationItem>
                <PaginationItem
                  className={`hover:cursor-pointer ${
                    currentPage === Math.ceil(data.length / itemsPerPage) ? 'text-gray-200 hover:text-gray-200' : ''
                  }`}
                >
                  <PaginationNext
                    className={`${
                      currentPage === Math.ceil(data.length / itemsPerPage)
                        ? 'hover:bg-transparent hover:text-gray-200 hover:cursor-not-allowed'
                        : undefined
                    }`}
                    onClick={handleNextPage} />
                </PaginationItem>
              </PaginationContent>
            </Pagination>
          )}
          {!isLoading && data?.length === 0 && (
            <>
              <p>No hay familias registradas</p>
            </>
          )}
        </div>
      </section>
    </AppLayout>
  );
}
