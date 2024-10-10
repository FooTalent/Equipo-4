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
  DialogClose
} from '@/components/ui';

export default function CreateUser() {
  return (
    <>
      <div className='md:grid w-full'>
        <Dialog>
          <DialogTrigger asChild>
            <Button className='p-6 h-44 md:h-56 grid justify-start w-full bg-orange-100 hover:bg-orange-100 rounded-lg'>
              <img src='/dashboard-admin/crear-usuario-desktop.svg' alt='Creare nuevo usuario' className='self-center' />
              <p className='self-start text-lg'>Crear nuevo usuario</p>
            </Button>
          </DialogTrigger>
          <DialogContent className="md:max-w-[450px] border-0 rounded-2xl w-[95%] mx-auto bg-gray-300">
            <DialogHeader>
              <DialogTitle className='text-left'>Crear usuario nuevo</DialogTitle>
            </DialogHeader>
            <div className="grid gap-6 py-2">
              <div className='flex flex-col gap-3'>
                <Label htmlFor="nombre">
              Nombre
                </Label>
                <Input
                  id='nombre'
                  placeholder='Escriba nombre'
                  className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                />
              </div>
              <div className='flex flex-col gap-3'>
                <Label htmlFor="apellido">
              Apellido
                </Label>
                <Input
                  id='apellido'
                  placeholder='Escriba apellido'
                  className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                />
              </div>
              <div className='flex flex-col gap-3'>
                <Label htmlFor="correo">
              Correo
                </Label>
                <Input
                  id='correo'
                  placeholder='Escriba correo'
                  className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                />
              </div>
              <div className='flex flex-col gap-3'>
                <Label htmlFor="contrasena">
              Contraseña
                </Label>
                <Input
                  id='contrasena'
                  placeholder='Escriba contraseña'
                  className='border-gray-400 focus-visible:ring-0 focus-visible:ring-offset-0'
                />
              </div>
            </div>
            <DialogFooter className='flex flex-row gap-2'>
              <DialogClose className='bg-transparent text-red-500 border border-red-500 hover:bg-red-500 hover:text-white text-lg font-light w-full rounded-md'>Cancelar</DialogClose>
              <Button type='submit' className='bg-emerald-500 hover:bg-white hover:border hover:border-emerald-500 hover:text-emerald-500 text-lg font-light w-full'>Confirmar</Button>
            </DialogFooter>
          </DialogContent>
        </Dialog>
      </div>
    </>
  );
}