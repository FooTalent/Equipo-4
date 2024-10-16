import { useState } from 'react';
import { useForm } from 'react-hook-form';
import {Link, useNavigate, useParams} from 'react-router-dom';
import { MdArrowBackIosNew } from 'react-icons/md';
import { Input } from '/src/components/ui/input';
import { Label } from '/src/components/ui/label';
import { Button } from '/src/components/ui/button';
import { Form } from '@/components/ui';
import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { useMutation } from "@tanstack/react-query";
import { toast } from "react-toastify";
import { resetPasswordFamilyApi } from "@/modules/auth/family/api/familyAuthApi.js";
import { IoIosEyeOff, IoIosEye } from 'react-icons/io';

const FamilyResetPassword = () => {
    const { resetToken } = useParams();
    const [showPassword, setShowPassword] = useState(false);
    const [showConfirmPassword, setShowConfirmPassword] = useState(false);

    const schema = yup.object({
        contrasenaHash: yup
            .string('Introduce una contraseña válida')
            .required('La contraseña es requerida')
            .min(8, 'La contraseña debe tener al menos 8 caracteres')
            .max(35, 'La contraseña no puede tener más de 35 caracteres')
            .matches(
                /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&_])[A-Za-z\d@$!%*#?&_]{8,}$/,
                'La contraseña debe contener al menos una letra, un número y un carácter especial'
            ),
        confirmarContrasena: yup
            .string()
            .oneOf([yup.ref('contrasenaHash'), null], 'Las contraseñas deben coincidir')
            .required('Confirma tu contraseña'),
    });

    const form = useForm({
        resolver: yupResolver(schema),
        defaultValues: {
            contrasenaHash: '',
            confirmarContrasena: '',
        }
    });

    const navigate = useNavigate();

    const mutation = useMutation({
        mutationFn: (data) => resetPasswordFamilyApi({ ...data, resetToken }),
        onSuccess: () => {
            toast.success('Tu contraseña ha sido actualizada exitosamente');
            navigate('/auth/familia/ingresar');
        },
        onError: () => {
            toast.error('Ha ocurrido un error al restablecer tu contraseña');
        },
    });

    const onSubmit = async (data) => {
        mutation.mutate(data);
    };

    return (
        <div className='flex flex-col items-center justify-center min-h-screen p-4 md:bg-green'>
            <Link to={'/auth'} className='hidden md:block left-2 md:bg-orange-500 w-[300px]'>
                <img src='/common/logo-phrase.svg' alt='family one' className='absolute top-30 sm:left-6 ml-12'/>
            </Link>
            <div className='max-w-[450px] z-10 w-full h-auto space-y-8 md:bg-white md:shadow-lg md:mx-auto md:w-full md:p-20 md:pb-20 md:pt-14 md:rounded-xl'>
                <div>
                    <h2 className='mt-6 text-2xl sm:text-3xl font-bold text-center text-gray-900'>
                        Restablecer contraseña
                    </h2>
                </div>
                <Form {...form}>
                    <form className='mt-8 space-y-6' onSubmit={form.handleSubmit(onSubmit)}>
                        <div className='rounded-md space-y-4'>
                            <div className='flex flex-col gap-2 relative'>
                                <Label htmlFor='contrasenaHash' className="text-sm font-medium text-gray-700">Nueva contraseña</Label>
                                <IoIosEyeOff
                                    onClick={() => setShowPassword(!showPassword)}
                                    className={`${
                                        !showPassword ? 'block' : 'hidden'
                                    } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                                />
                                <IoIosEye
                                    onClick={() => setShowPassword(!showPassword)}
                                    className={`${
                                        showPassword ? 'block' : 'hidden'
                                    } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                                />
                                <Input
                                    id='contrasenaHash'
                                    name='contrasenaHash'
                                    type={showPassword ? 'text' : 'password'}
                                    placeholder='Escribe tu nueva contraseña'
                                    {...form.register('contrasenaHash')}
                                />
                                {form.formState.errors.contrasenaHash && <p className="text-red-500 text-xs">{form.formState.errors.contrasenaHash.message}</p>}
                            </div>
                            <div className='flex flex-col gap-2 relative'>
                                <Label htmlFor='confirmarContrasena' className="text-sm font-medium text-gray-700">Confirmar contraseña</Label>
                                <IoIosEyeOff
                                    onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                                    className={`${
                                        !showConfirmPassword ? 'block' : 'hidden'
                                    } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                                />
                                <IoIosEye
                                    onClick={() => setShowConfirmPassword(!showConfirmPassword)}
                                    className={`${
                                        showConfirmPassword ? 'block' : 'hidden'
                                    } absolute text-gray right-0 top-[36.6px] mr-2 hover:cursor-pointer`}
                                />
                                <Input
                                    id='confirmarContrasena'
                                    name='confirmarContrasena'
                                    type={showConfirmPassword ? 'text' : 'password'}
                                    placeholder='Confirma tu nueva contraseña'
                                    {...form.register('confirmarContrasena')}
                                />
                                {form.formState.errors.confirmarContrasena && <p className="text-red-500 text-xs">{form.formState.errors.confirmarContrasena.message}</p>}
                            </div>
                        </div>

                        <div>
                            <Button
                                type='submit'
                                variant='default'
                                className='w-full mt-4 py-6 bg-orange-400  hover:border-orange-500 hover:border-2 hover:bg-white text-black hover:text-black'
                            >
                                {'Restablecer contraseña'}
                            </Button>
                        </div>
                    </form>
                </Form>
            </div>
        </div>
    );
};

export default FamilyResetPassword;