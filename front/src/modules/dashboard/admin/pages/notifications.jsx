import { AppLayout } from '@/layouts/app-layout';
import { useNavigate } from 'react-router-dom';
import Notification from '../components/notification';
import { useQuery } from '@tanstack/react-query';
import { getAdminNotification } from '../api';
import { toast } from 'react-toastify';
import { useEffect } from 'react';
import useAuthStore from '@/store/user';

export default function AdminNotifications() {
  const navigate = useNavigate();
  const user = useAuthStore((state) => state.user);
  const { data, isLoading } = useQuery({
    queryKey: ['notificaions'],
    queryFn: () => getAdminNotification(user?.id),
    staleTime: 5 * 60 * 1000, // data is fresh for 5 minutes
    cacheTime: 10 * 60 * 1000, // cache lasts for 10 minutes
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  useEffect(() => {

  }, []);
  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid'>
        <div className='p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:mt-[10vh] md:h-fit md:pb-16 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex flex-col gap-4'>
            <div className='flex md:flex-col gap-2 md:gap-5'>
              <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
              <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>Notificaciones</p>
            </div>
          </div>
          <div className='flex flex-col gap-3'>
            {isLoading && (
              <div className='grid justify-center items-center mt-12'>
                <div className='animate-spin rounded-full h-12 w-12 border-b-2 border-gray-400'></div>
              </div>
            )}
            {!isLoading && data && <Notification message={data?.mensaje} read={data?.visto} />}
          </div>
        </div>
      </section>
    </AppLayout>
  );
}