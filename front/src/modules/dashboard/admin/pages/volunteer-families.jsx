import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from '@/components/ui';
import { AppLayout } from '@/layouts/app-layout';
import { useNavigate } from 'react-router-dom';

export default function VolunteerFamilies () {
  const navigate = useNavigate();
  // const { data: usersData, isLoading: usersLoading } = useQuery({
  //   queryKey: ['usuarios'],
  //   queryFn: getAllVolunteersApi,
  //   staleTime: 5 * 60 * 1000, // data is fresh for 5 minutes
  //   cacheTime: 10 * 60 * 1000, // cache lasts for 10 minutes
  //   onError: () => {
  //     toast.error('Ha ocurrido un error');
  //   },
  // });
  // const { data: volunteersData, isLoading: volunteersLoading } = useQuery({
  //   queryKey: ['voluntarios'],
  //   queryFn: getAllUsers,
  //   staleTime: 5 * 60 * 1000, // data is fresh for 5 minutes
  //   cacheTime: 10 * 60 * 1000, // cache lasts for 10 minutes
  //   onError: () => {
  //     toast.error('Ha ocurrido un error');
  //   },
  // });
  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid md:items-center'>
        <div className='p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex flex-col gap-4'>
            <div className='flex md:flex-col gap-2 md:gap-5'>
              <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
              <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>Familias Voluntarias</p>
            </div>
            <p className='px-2 md:px-0 text-lf'>Estas son las familias disponible para ser voluntarias:</p>
          </div>
          <div className='flex flex-col gap-3'>
            <Table>
              <TableHeader>
                <TableRow>
                  <TableHead className='w-[100px]'>Nombre</TableHead>
                  <TableHead>Estado Voluntario</TableHead>
                </TableRow>
              </TableHeader>
              <TableBody>
                <TableRow>
                  <TableCell className='w-[50%]'>Elton Renner</TableCell>
                  <TableCell className='w-[50%]'>Activo</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell className='w-[33%]'>Frederica Ratke</TableCell>
                  <TableCell className='w-[33%]'>Activo</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell className='w-[33%]'>Leo Treutel</TableCell>
                  <TableCell className='w-[33%]'>Activo</TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </div>
        </div>
      </section>
    </AppLayout>
  );
}