import { useState } from 'react';
import { useForm } from 'react-hook-form';
import { useNavigate, Link } from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Input } from '/src/components/ui/input';
import { Label } from '/src/components/ui/label';
import { Button } from '/src/components/ui/button';
import { Form } from '@/components/ui';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { useMutation } from "@tanstack/react-query";
import { toast } from "react-toastify";
import { forgotPasswordFamilyApi } from "@/modules/auth/family/api/familyAuthApi.js";

const FamilyForgotPassword = () => {
    const schema = yup.object({
        correo: yup.string('Introduce un correo válido')
            .required('Introduce un correo válido')
            .email('Introduce un correo válido'),
    });

    const form = useForm({
        resolver: yupResolver(schema),
        defaultValues: {
            correo: '',
        }
    });

    const navigate = useNavigate();

    const mutation = useMutation({
        mutationFn: forgotPasswordFamilyApi,
        onSuccess: (data) => {
            toast.success('Se ha enviado un correo con instrucciones para restablecer tu contraseña');
            navigate('/auth/familia/ingresar');
        },
        onError: () => {
            toast.error('Ha ocurrido un error al procesar tu solicitud');
        },
    });

    const onSubmit = async (data) => {
        console.log('Datos enviados a la API de olvidar contraseña:', data);
        mutation.mutate(data);
    };

    return (
        <div className='flex flex-col items-center justify-center min-h-screen p-4 md:bg-green'>
            <Link className='absolute z-30 top-8 left-4 sm:top-8 sm:left-8 bg-white md:p-4 md:shadow-md md:rounded-xl left-8' to={'/auth/familia/ingresar'}>
                <MdArrowBackIosNew className="text-2xl" />
            </Link>
            <Link to={'/auth'} className='hidden md:block z-30 left-4 md:bg-orange-500 w-[300px]'>
                <img src='/common/logo-phrase.svg' alt='family one' className='absolute top-30 sm:left-20 ml-20'/>
            </Link>
            <div className='max-w-[450px] w-full h-auto space-y-2 md:bg-white md:h-3/4 md:shadow-lg md:mx-auto md:w-full md:p-16 md:pb-20 md:pt-14 md:rounded-xl'>
                <div>
                    <h2 className='mt-6 mb-6 text-xl sm:text-2xl font-bold text-center text-gray-900'>
                        Recuperar contraseña
                    </h2>
                </div>
                <div>
                    <p className="text-left mt-4 mb-6">Introduce tu Email y te enviaremos un correo electrónico con instrucciones para recuperar tu contraseña</p>
                </div>
                <Form {...form}>
                    <form className='mt-8 space-y-6' onSubmit={form.handleSubmit(onSubmit)}>
                        <div className='rounded-md space-y-4'>
                            <div className='flex flex-col gap-2'>
                                <Label htmlFor='correo' className="text-sm font-medium text-gray-700">
                                    Correo electrónico
                                </Label>
                                <Input
                                    id='correo'
                                    name='correo'
                                    type='email'
                                    className='px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500'
                                    placeholder='Ingresa tu correo electrónico'
                                    {...form.register('correo', { required: true })}
                                />
                                {form.formState.errors && <p className="text-red-500 text-xs">{form?.formState?.errors?.correo?.message}</p>}
                            </div>
                        </div>

                        <div>
                            <Button
                                type='submit'
                                variant='default'
                                className='w-full mt-4 py-6 bg-orange-400  hover:border-orange-500 hover:border-2 hover:bg-white text-white hover:text-orange-500'
                            >
                                {'Enviar instrucciones'}
                            </Button>
                        </div>
                    </form>
                </Form>
            </div>
        </div>
    );
};

export default FamilyForgotPassword;