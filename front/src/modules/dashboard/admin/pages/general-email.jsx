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
import { sendGeneralEmailApi } from '@/modules/dashboard/admin/api';
import {toast} from "react-toastify";
export default function GeneralEmail () {
  const navigate = useNavigate();
  const form = useForm({
    defaultValues: {
      destinatarios: '',
      asunto: '',
      mensaje: ''
    }
  });

  const onSubmit = async (values) => {
    try {
      const response = await sendGeneralEmailApi(values);

      if (typeof response === 'string') {
        // Si es un string, es un mensaje de error
        toast({
          variant: "destructive",
          title: "Error",
          description: response,
        });
        return;
      }

      toast({
        title: "Éxito",
        description: "El email ha sido enviado correctamente",
      });

      navigate('/admin/dashboard');

    } catch (error) {
      toast({
        variant: "destructive",
        title: "Error",
        description: "No se pudo enviar el email",
      });
    }
  };
  return (
      <AppLayout>
        <section className='h-full md:bg-grayDefault md:grid md:items-center'>
          <div className='h-full relative p-0 grid md:flex md:flex-col gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
            <div className='flex flex-col gap-4'>
              <div className='flex md:flex-col gap-2 md:gap-5'>
                <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
                <p className='self-center -mb-2 md:-mb-0 text-2xl md:w-full'>E-mail General</p>
              </div>
            </div>
            <Form {...form}>
              <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-6">
                <div className='flex flex-col gap-6  md:-mt-0'>
                  <div>
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
                  </div>
                  <FormField
                      control={form.control}
                      name='asunto'
                      rules={{ required: 'El asunto es requerido' }}
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
                      rules={{ required: 'El mensaje es requerido' }}
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
                  <div className=' absolute bottom-6 w-[96.5%] mx-auto'>
                    <Button className='bg-orange-500 hover:bg-orange-600 w-full text-black text-lg font-light py-6'>Enviar</Button>
                  </div>
                </div>
              </form>
            </Form>
          </div>
        </section>
      </AppLayout>
  );
}