import { useState } from 'react';
import {
  Dialog,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
  Label,
  Input,
  Button,
  DialogClose,
  Form,
  FormItem,
  FormControl,
  FormMessage,
  FormField,
  Select,
  SelectItem,
  SelectContent,
  SelectTrigger,
  SelectValue
} from '@/components/ui';
import { yupResolver } from '@hookform/resolvers/yup';
import { useForm } from 'react-hook-form';
import { schemaCreateUser } from '../schemas/schemaCreateUser';
import { toast } from 'react-toastify';
import { useMutation } from '@tanstack/react-query';
import { createUserApi, sendUserDataApi } from '../api';
import Spinner from '@/components/ui/spinner';

export default function CreateUser() {
  const [isOpen, setIsOpen] = useState(false);
  const [confirmed, setConfirmed] = useState(false);
  const form = useForm({
    resolver: yupResolver(schemaCreateUser),
    defaultValues: {
      tipoUsuario: '',
      nombre: '',
      apellido: '',
      correo: '',
      contrasenaHash: ''
    }
  });
  const resetForm = () => {
    form.reset();
    setConfirmed(false);
  };
  const handleDialogChange = (open) => {
    setIsOpen(open);
    if (!open) {
      resetForm();
    }
  };
  const copyToClipboard = () => {
    const text = `Correo: ${form.getValues('correo')}\nContraseña: ${form.getValues('contrasenaHash')}`;
    navigator.clipboard.writeText(text)
      .then(() => {
        toast.success('Copiado al portapapeles');
      }).catch(err => {
        toast.error(err);
      });
  };
  const mutationCreateUser = useMutation({
    mutationFn: createUserApi,
    onSuccess: (data) => {
      if (data.correo) {
        setConfirmed(true);
      } else {
        toast.error(data);
      }
    },
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  const mutationSendData = useMutation({
    mutationFn: sendUserDataApi,
    onSuccess: (data) => {
      if (data === 'Email enviado exitosamente!') {
        toast.success('Email enviado exitosamente');
      } else {
        toast.error(data);
      }
    },
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  const onSubmit = (data) => {
    mutationCreateUser.mutate(data);
  };
  const sendEmail = () => {
    const data = {
      correo: form.getValues('correo'),
      contrasenaHash: form.getValues('contrasenaHash')
    };
    mutationSendData.mutate(data);
  };
  return (
    <>
      <div className='md:grid w-full'>
        <Dialog open={isOpen} onOpenChange={handleDialogChange}>
          <DialogTrigger asChild>
            <Button className='p-6 h-44 md:h-56 grid justify-start w-full bg-orange-100 hover:bg-orange-100 rounded-lg'>
              <img src='/dashboard-admin/crear-usuario-desktop.svg' alt='Creare nuevo usuario' className='self-center' />
              <p className='self-start text-lg'>Crear nuevo usuario</p>
            </Button>
          </DialogTrigger>
          <DialogContent className='md:max-w-[450px] border-0 rounded-2xl w-[95%] mx-auto bg-gray-300'>
            <DialogHeader>
              <DialogTitle className='text-left'>{confirmed ? <p>Usuario creado con éxito! <br /> <span className='block py-1'>Las credenciales son:</span></p> : 'Crear usuario nuevo'}</DialogTitle>
            </DialogHeader>
            <Form {...form}>
              <form onSubmit={form.handleSubmit(onSubmit)} className={`${confirmed ? 'hidden' : 'block'}`}>
                <div className='grid gap-3 py-2'>
                  <FormField
                    control={form.control}
                    name='tipoUsuario'
                    render={({ field }) => (
                      <FormItem>
                        <Label>Tipo de usuario</Label>
                        <Select onValueChange={field.onChange} defaultValue={field.value}>
                          <FormControl>
                            <SelectTrigger>
                              <SelectValue placeholder='' className='text-gray-200 text-opacity-25' />
                            </SelectTrigger>
                          </FormControl>
                          <SelectContent>
                            <SelectItem value='FAMILIA'>Familia</SelectItem>
                            <SelectItem value='ADMIN'>Administrador</SelectItem>
                          </SelectContent>
                        </Select>
                        <FormMessage />
                      </FormItem>
                    )}
                  />
                  <div className='flex flex-col gap-3'>
                    <Label htmlFor="nombre">
              Nombre
                    </Label>
                    <Input
                      id='nombre'
                      name='nombre'
                      placeholder='Escriba nombre'
                      className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                      {...form.register('nombre', { required: true })}
                    />
                    {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.nombre?.message}</p>}
                  </div>
                  <div className='flex flex-col gap-3'>
                    <Label htmlFor="apellido">
              Apellido
                    </Label>
                    <Input
                      id='apellido'
                      name='apellido'
                      placeholder='Escriba apellido'
                      className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                      {...form.register('apellido', { required: true })}
                    />
                    {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.apellido?.message}</p>}
                  </div>
                  <div className='flex flex-col gap-3'>
                    <Label htmlFor="correo">
              Correo
                    </Label>
                    <Input
                      id='correo'
                      name='correo'
                      placeholder='Escriba correo'
                      className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                      {...form.register('correo', { required: true })}
                    />
                    {form.formState.errors && <p className="text-red-500 text-sm -mt-1">{form?.formState?.errors?.correo?.message}</p>}
                  </div>
                  <div className='flex flex-col gap-3'>
                    <Label htmlFor="contrasena">
              Contraseña
                    </Label>
                    <Input
                      id='contrasenaHash'
                      name='contrasenaHash'
                      placeholder='Escriba contraseña'
                      className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                      {...form.register('contrasenaHash', { required: true })}
                    />
                    {form.formState.errors && <p className="text-red-500 text-sm">{form?.formState?.errors?.contrasenaHash?.message}</p>}
                  </div>
                </div>
                <DialogFooter className='flex flex-row gap-2 mt-4'>
                  <DialogClose className={` ${mutationCreateUser.isPending ? 'hidden' : ''} bg-transparent text-red-500 border border-red-500 hover:bg-red-500 hover:text-white text-lg font-light w-full rounded-md`}>Cancelar</DialogClose>
                  <Button type='submit' className='bg-emerald-500 hover:bg-white hover:border hover:border-emerald-500 hover:text-emerald-500 text-lg font-light w-full'>{mutationCreateUser.isPending ? <Spinner /> : 'Confirmar'}</Button>
                </DialogFooter>
              </form>
            </Form>
            <Form>
              <form className={`${confirmed ? 'block relative' : 'hidden'}`}>
                <div className="grid gap-3 py-2">
                  <div className='flex flex-col gap-3'>
                    <Label htmlFor="correo">
              Correo
                    </Label>
                    <Input
                      disabled
                      value={form.getValues('correo')}
                      className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                    />
                  </div>
                  <div className='flex flex-col gap-3'>
                    <Label>
              Contraseña
                    </Label>
                    <Input
                      disabled
                      value={form.getValues('contrasenaHash')}
                      className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                    />
                  </div>
                </div>

                <Button type='button' onClick={sendEmail} className='mt-4 mb-2 bg-transparent text-black font-base bg-orange-400 hover:bg-orange-400 text-lg w-full rounded-md'>
                  {mutationSendData.isPending ? <Spinner /> : 'Enviar vía email'}
                </Button>
                <Button type='button' onClick={copyToClipboard} className='bg-emerald-500 hover:bg-emerald-500 hover:border hover:border-emerald-500 text-lg font-light w-full'>Copiar en portapapeles</Button>

              </form>
            </Form>
          </DialogContent>
        </Dialog>
      </div>
    </>
  );
}