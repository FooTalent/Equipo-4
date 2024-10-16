import { useEffect, useState } from 'react';
import useAuthStore from '@/store/user';
import { AppLayout } from '@/layouts/app-layout';
import { useNavigate } from 'react-router-dom';
import { Button, Form, Input } from '@/components/ui';
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
import { schemaAdminProfile } from '../schemas/schemaAdminProfile';
import { useMutation } from '@tanstack/react-query';
import { adminProfileApi } from '../api';
import { toast } from 'react-toastify';
import Spinner from '@/components/ui/spinner';

export default function AdminProfile() {
  const user = useAuthStore((state) => state.user);
  const setUser = useAuthStore((state) => state.setUser);
  const navigate = useNavigate();
  const [error, setError] = useState(false);
  const [editFields, setEditFields] = useState({
    nombre: false,
    apellido: false,
    correo: false
  });
  const form = useForm({
    resolver: yupResolver(schemaAdminProfile),
    defaultValues: {
      nombre: user?.nombre ? user.nombre : '',
      apellido: user?.apellido ? user.apellido : '',
      correo: user?.correo ? user.correo : '',
    }
  });
  const updateEdit = (fieldName) => {
    setEditFields(prevFields => ({
      ...prevFields,
      [fieldName]: !prevFields[fieldName]
    }));
  };
  const handleReset = (fieldName) => {
    form.setValue(fieldName, form.formState.defaultValues[fieldName]);
    form.clearErrors(fieldName);
    setEditFields((prevFields) => ({
      ...prevFields,
      [fieldName]: false
    }));
  };
  const handleCancle = () => {
    form.reset();
    setEditFields({
      nombre: false,
      apellido: false,
      correo: false,
    });
  };
  const mutation = useMutation({
    mutationFn: adminProfileApi,
    onSuccess: (data) => {
      if (data) {
        setUser(data);
        toast.success('Perfil actualizado exitosamente');
        setEditFields({
          nombre: false,
          apellido: false,
          correo: false
        });
        form.reset({
          nombre: data.nombre,
          apellido: data.apellido,
          correo: data.correo
        });
      } else {
        toast.error(data);
      }
    },
    onError: () => {
      toast.error('Ha ocurrido un error');
    },
  });
  const onSubmit = async (data) => {
    const newData = {
      id: user.id,
      nombre: data.nombre,
      apellido: data.apellido,
      corre: data.correo
    };
    mutation.mutate(newData);
  };
  const watchedFields = form.watch();
  useEffect(() => {
    const isNombreModified = watchedFields.nombre !== form.formState.defaultValues.nombre;
    const isApellidoModified = watchedFields.apellido !== form.formState.defaultValues.apellido;
    const isCorreoModified = watchedFields.correo !== form.formState.defaultValues.correo;
    if (isNombreModified || isApellidoModified || isCorreoModified) {
      setError(true);
    } else {
      setError(false);
    }
  }, [form.formState.defaultValues.apellido, form.formState.defaultValues.correo, form.formState.defaultValues.nombre, watchedFields]);
  return (
    <AppLayout>
      <section className='h-full md:bg-grayDefault md:grid md:items-center'>
        <div className='p-0 h-full flex flex-col md:flex-col gap-16 md:gap-6 max-w-6xl mx-auto px-2 md:px-4 md:py-4 md:h-3/4 md:bg-white md:w-[650px] md:rounded-lg md:border-0 md:mx-auto'>
          <div className='flex h-fit py-1 gap-2 md:gap-5'>
            <img onClick={() => navigate('/admin/dashboard')} src='/common/arrow-left.svg' alt='Regresar a la página principal' className='self-start pt-2 md:pt-0 hover:cursor-pointer' />
            <p className='self-start mt-1 md:mt-0 md:-mb-0 text-2xl md:w-full'>Perfil Administrador</p>
          </div>
          <Form {...form}>
            <form className='h-full md:h-auto grid grid-rows-2 gap-2' onSubmit={form.handleSubmit(onSubmit)}>
              <div className='flex flex-col gap-3'>
                <div className='relative'>
                  <Input
                    name='nombre'
                    className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                    placeholder='Nombre'
                    disabled={!editFields.nombre}
                    {...form.register('nombre', { required: false })}
                  />
                  <button type='button' onClick={() => updateEdit('nombre')} className={`absolute top-2 right-2 ${editFields.nombre ? 'hidden' : 'block'}`}><img src='/common/edit-input-field.svg' alt='editar' /></button>
                  <button type='button' onClick={() => handleReset('nombre')} className={`absolute top-2 right-2 ${editFields.nombre ? 'block' : 'hidden'}`}><img src='/common/delete.svg' alt='borrar' /></button>
                  <button type='button' onClick={() => updateEdit('nombre')} className={`absolute top-2 text-green-700 right-9 ${editFields.nombre ? 'block' : 'hidden'}`}><img src='/common/save.svg' alt='borrar' className='text-green-400' /></button>
                  {form.formState.errors && <p className='text-red-500 text-sm py-1'>{form?.formState?.errors?.nombre?.message}</p>}
                </div>
                <div className='relative'>
                  <Input
                    name='apellido'
                    className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                    placeholder='Apellido'
                    disabled={!editFields.apellido}
                    {...form.register('apellido', { required: false })}
                  />
                  <button type='button' onClick={() => updateEdit('apellido')} className={`absolute top-2 right-2 ${editFields.apellido ? 'hidden' : 'block'}`}><img src='/common/edit-input-field.svg' alt='editar' /></button>
                  <button type='button' onClick={() => handleReset('apellido')} className={`absolute top-2 right-2 ${editFields.apellido ? 'block' : 'hidden'}`}><img src='/common/delete.svg' alt='borrar' /></button>
                  <button type='button' onClick={() => updateEdit('apellido')} className={`absolute top-2 text-green-700 right-9 ${editFields.apellido ? 'block' : 'hidden'}`}><img src='/common/save.svg' alt='borrar' className='text-green-400' /></button>
                  {form.formState.errors && <p className='text-red-500 text-sm py-1'>{form?.formState?.errors?.apellido?.message}</p>}
                </div>
                <div className='relative'>
                  <Input
                    className='border-orange-300 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:text-gray-400'
                    placeholder='Correo'
                    disabled={!editFields.correo}
                    {...form.register('correo', { required: false })}
                  />
                  <button type='button' onClick={() => updateEdit('correo')} className={`absolute top-2 right-2 ${editFields.correo ? 'hidden' : 'block'}`}><img src='/common/edit-input-field.svg' alt='editar' /></button>
                  <button type='button' onClick={() => handleReset('correo')} className={`absolute top-2 right-2 ${editFields.correo ? 'block' : 'hidden'}`}><img src='/common/delete.svg' alt='borrar' /></button>
                  <button type='button' onClick={() => updateEdit('correo')} className={`absolute top-2 text-green-700 right-9 ${editFields.correo ? 'block' : 'hidden'}`}><img src='/common/save.svg' alt='borrar' className='text-green-400' /></button>
                  {form.formState.errors && <p className='text-red-500 text-sm py-1'>{form?.formState?.errors?.correo?.message}</p>}
                </div>
              </div>
              <div className='h-full md:mt-0 flex flex-col justify-end gap-2'>
                <Button type='submit' disabled={!error} className='disabled:bg-gray-400 disabled:text-black bg-green-600 hover:bg-green-700  text-white'>{mutation.isPending ? <Spinner /> : 'Guardar Cambios'}</Button>
                <Button type='button' onClick={() => handleCancle()} disabled={!error} className={`${mutation.isPending ? 'hidden' : ''} disabled:bg-gray-400 disabled:text-black disabled:border-gray-400 bg-white hover:bg-orange-400 text-orange-400 hover:text-white border-2 border-orange-400`}>Cancelar</Button>
              </div>
            </form>
          </Form>
        </div>
      </section>
    </AppLayout>
  );
}