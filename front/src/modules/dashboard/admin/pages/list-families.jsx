import { useEffect, useState } from 'react';
import { AppLayout } from '@/layouts/app-layout';
import { useNavigate } from 'react-router-dom';
import { useQuery } from '@tanstack/react-query';
import { getAllFamiliesApi } from '../api';
import { toast } from 'react-toastify';
import Familia from '../components/familia';
import {
  Input,
  Pagination,
  PaginationContent,
  PaginationItem,
  PaginationNext,
  PaginationPrevious,
} from '@/components/ui';

export default function ListFamilies() {
  const [currentFamilies, setCurrentFamilies] = useState(null);
  const [index, setIndex] = useState(5);
  const navigate = useNavigate();
  const { data, isLoading } = useQuery({
    queryKey: ['families'],
    queryFn: getAllFamiliesApi,
    staleTime: 5 * 60 * 1000, // data is fresh for 5 minutes
    cacheTime: 10 * 60 * 1000, // cache lasts for 10 minutes
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });

  const handlePreviousIndex = () => {
    if (index > 5) {
      const remainingItems = data.length - (index - 5);
      if (remainingItems < 5) {
      // If fewer than 5 items were on the last page, navigate back by a smaller slice
        setCurrentFamilies(data.slice(index - (index % 5), index - (index % 5) + 5));
      } else {
      // Otherwise, navigate back by a full slice of 5 items
        setCurrentFamilies(data.slice(index - 10, index - 5));
      }
      setIndex((prev) => prev - 5);
    }
  };

  const handleNextIndex = () => {
    const remainingItems = data?.length - index;
    if (remainingItems > 5) {
      setCurrentFamilies(data.slice(index, index + 5));
      setIndex((prev) => prev + 5);
    } else if (remainingItems > 0) {
      setCurrentFamilies(data.slice(index, index + remainingItems));
      setIndex((prev) => prev + remainingItems);
    }
  };

  useEffect(() => {
    if (data && data.length > 0) {
      if (data.length >= 5) {
        setIndex(5);
        setCurrentFamilies(data.slice(0, 5));
      } else {
        setIndex(data.length);
        setCurrentFamilies(data.slice(0, data.length));
      }
    } else {
      setCurrentFamilies([]);
    }
  }, [data]);

  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid md:items-center'>
        <div className='p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
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
              <div className='relative my-3'>
                <Input
                  placeholder='Busca por apellido, región, estado de acogimiento'
                  className='rounded-3xl bg-neutral-200 placeholder:text-emerald-500 py-4 px-12 focus-visible:ring-0 focus-visible:ring-offset-0'
                />
                <img src='/common/search.svg' alt='buscar familia' className=' absolute top-2 left-4'/>
                <img src='/common/close-circle.svg' alt='borrar el buscador' className=' absolute top-2 right-4' />
              </div>
            </>)}
          </div>
          {isLoading && (
            <div className='grid justify-center items-center mt-12'>
              <div className='animate-spin rounded-full h-12 w-12 border-b-2 border-gray-400'></div>
            </div>
          )}
          {!isLoading && data?.length !== 0 && (
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
          {!isLoading && data?.length !== 0 && (
            <Pagination>
              <PaginationContent className='flex justify-between w-full'>
                <PaginationItem
                  className={`hover:cursor-pointer ${index <= 5 ? 'text-gray-200 hover:text-gray-200' : ''}`}
                >
                  <PaginationPrevious
                    className={`${
                      index <= 5 ? 'hover:bg-transparent hover:text-gray-200 hover:cursor-not-allowed' : undefined
                    }`}
                    aria-disabled={index <= 5}
                    onClick={handlePreviousIndex}
                  />
                </PaginationItem>
                <PaginationItem className={`hover:cursor-pointer ${data?.length - index < 5 ? 'text-gray-200 hover:text-gray-200' : ''}`}>
                  <PaginationNext
                    className={`${
                      data?.length - index < 5 ? 'hover:bg-transparent hover:text-gray-200 hover:cursor-not-allowed' : undefined
                    }`}
                    aria-disabled={data?.length - index < 5}
                    onClick={handleNextIndex} />
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
