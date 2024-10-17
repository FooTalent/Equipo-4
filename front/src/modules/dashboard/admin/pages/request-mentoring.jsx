import { AppLayout } from '@/layouts/app-layout';
import { useQuery } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import { getAllMentoringApi } from '../api';
import { toast } from 'react-toastify';
import { useEffect, useState } from 'react';
import {
  Input,
  Pagination,
  PaginationContent,
  PaginationItem,
  PaginationNext,
  PaginationPrevious,
} from '@/components/ui';

export default function RequestMentoring() {
  const [currentFamilies, setCurrentFamilies] = useState(null);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5;
  const navigate = useNavigate();

  const { data, isLoading } = useQuery({
    queryKey: ['mentoring-families'],
    queryFn: getAllMentoringApi,
    staleTime: 5 * 60 * 1000,
    cacheTime: 10 * 60 * 1000,
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

  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid md:items-center'>
        <div className='p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex flex-col gap-4'>
            <div className='flex md:flex-col gap-2 md:gap-5'>
              <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
              <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>Solicitud de Mentorias</p>
            </div>
            <p className='px-2 md:px-0 text-lf'>Estas son las familias que esperan por recibir mentorías:</p>
          </div>
          <div className='flex flex-col gap-3'>
            <>
              {isLoading && (
                <div className='grid justify-center items-center mt-12'>
                  <div className='animate-spin rounded-full h-12 w-12 border-b-2 border-gray-400'></div>
                </div>
              )}
              {!isLoading && data?.length !== 0 && (
                <>
                  {currentFamilies &&
                currentFamilies?.map((familia) => (
                  <Input
                    key={familia?.id}
                    placeholder={familia?.familiaMentora?.nombre}
                  />
                ))}
                </>
              )}
              {!isLoading && data?.length !== 0 && (
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
                        onClick={handleNextPage}
                      />
                    </PaginationItem>
                  </PaginationContent>
                </Pagination>
              )}
              {!isLoading && data?.length === 0 && (
                <>
                  <p>No hay familias que esperan por recibir mentorías</p>
                </>
              )}
            </>
          </div>
        </div>
      </section>
    </AppLayout>
  );
}
