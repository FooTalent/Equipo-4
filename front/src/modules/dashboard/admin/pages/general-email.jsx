import {
  Input,
  Form,
  Label,
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
  FormControl,
  FormField,
  FormItem,
  FormMessage,
  Button
} from '@/components/ui';
import { Textarea } from '@/components/ui/textarea';
import { AppLayout } from '@/layouts/app-layout';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { useMutation } from '@tanstack/react-query';
import { sendGeneralEmailApi } from '@/modules/dashboard/admin/api';
import { toast } from 'react-toastify';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';

export default function GeneralEmail() {
  const navigate = useNavigate();

  // Schema de validación
  const schema = yup.object({
    destinatarios: yup
      .string()
      .required('Debe seleccionar los destinatarios'),
    asunto: yup
      .string()
      .required('El asunto es requerido')
      .min(3, 'El asunto debe tener al menos 3 caracteres')
      .max(100, 'El asunto no puede tener más de 100 caracteres'),
    mensaje: yup
      .string()
      .required('El mensaje es requerido')
      .min(10, 'El mensaje debe tener al menos 10 caracteres')
  });

  const form = useForm({
    resolver: yupResolver(schema),
    defaultValues: {
      destinatarios: '',
      asunto: '',
      mensaje: ''
    }
  });

  // Mutación para enviar el email
  const mutation = useMutation({
    mutationFn: sendGeneralEmailApi,
    onSuccess: () => {
      toast.success('Email enviado exitosamente');
      navigate('/admin/dashboard');
    },
    onError: () => {
      toast.error('Ha ocurrido un error al enviar el email');
    },
  });

  const onSubmit = async (data) => {
    mutation.mutate(data);
  };

  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid'>
        <div className='h-full relative p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-fit md:mt-[10vh]  md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex flex-col gap-4'>
            <div className='flex md:flex-col gap-2 md:gap-5'>
              <img
                onClick={() => navigate('/admin/dashboard')}
                src='/common/arrow-left.svg'
                alt='Regresar a la página principal'
                className='self-start pt-2 md:pt-0 hover:cursor-pointer'
              />
              <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>E-mail General</p>
            </div>
          </div>

          <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)}>
              <div className='flex flex-col gap-6 md:-mt-0'>
                <FormField
                  control={form.control}
                  name='destinatarios'
                  render={({ field }) => (
                    <FormItem>
                      <Label>Destinatarios</Label>
                      <Select onValueChange={field.onChange} defaultValue={field.value}>
                        <FormControl>
                          <SelectTrigger>
                            <SelectValue placeholder='Selecione destinatarios' className='placeholder:text-gray-400' />
                          </SelectTrigger>
                        </FormControl>
                        <SelectContent>
                          <SelectItem value='general'>Listado General</SelectItem>
                          <SelectItem value='voluntarias'>Familias voluntarias</SelectItem>
                          <SelectItem value='mentoria'>Familias a la espera de mentoria</SelectItem>
                          <SelectItem value='personal'>Personal</SelectItem>
                        </SelectContent>
                      </Select>
                      <FormMessage />
                    </FormItem>
                  )}
                />

                <FormField
                  control={form.control}
                  name='asunto'
                  render={({ field }) => (
                    <FormItem>
                      <Label>Asunto</Label>
                      <Input
                        {...field}
                        className='border-gray-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                        placeholder='Escriba el asunto'
                      />
                      <FormMessage />
                    </FormItem>
                  )}
                />

                <FormField
                  control={form.control}
                  name='mensaje'
                  render={({ field }) => (
                    <FormItem>
                      <Label>Mensaje</Label>
                      <Textarea
                        {...field}
                        placeholder='Escriba aquí su mensaje'
                        className='border-gray-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400 resize-none'
                      />
                      <FormMessage />
                    </FormItem>
                  )}
                />

                <div className='bottom-6 w-[96.5%] mx-auto'>
                  <Button
                    type='submit'
                    variant='orange'
                    className='w-full font-semibold text-black text-lg py-6'
                    disabled={mutation.isPending}
                  >
                    {mutation.isPending ? (
                      <div className='animate-spin rounded-full h-6 w-6 border-b-2 border-gray-400'></div>
                    ) : (
                      'Enviar'
                    )}
                  </Button>
                </div>
              </div>
            </form>
          </Form>
        </div>
      </section>
    </AppLayout>
  );
}