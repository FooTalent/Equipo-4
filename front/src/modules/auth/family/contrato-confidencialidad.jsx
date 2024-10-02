import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Button } from '@/components/ui/button';
import { MdArrowBackIosNew } from 'react-icons/md';


function ContratoConfidencialidad() {
    const navigate = useNavigate();


    const handleBack = () => {
        navigate('/auth/familia/personalizar');
    };

    return (
        <div className="p-4 flex flex-col items-center">

            <Link className='self-start mb-6 mt-6' to={'/auth/familia/personalizar'}>
                <MdArrowBackIosNew />
            </Link>


            <h1 className="text-2xl font-bold mb-6">Contrato de confidencialidad</h1>

            <p className="text-gray-700 mb-2 text-center">
                ipsum quam Quisque tempor In Quisque sed vitae placerat ipsum eget maximus risus Donec Cras amet, sollicitudin. id sit non massa nisl. volutpat at ex amet, Ut
            </p>
            <p className="text-gray-700 mb-2 text-center">
                nisi fringilla at, risus eu risus tincidunt felis, non elit. id tincidunt Nunc vitae ex. Vestibulum viverra nec elit. non, amet, nisi nec nec non, faucibus id
            </p>
            <p className="text-gray-700 mb-2 text-center">
                quis Vestibulum massa non vel hendrerit risus vitae tempor nibh Cras elit Praesent porta elit. laoreet placerat. at tortor. convallis. id ex hendrerit vitae
            </p>
            <p className="text-gray-700 mb-2 text-center">
                placerat. viverra Ut libero, gravida quam dui. elit tincidunt facilisis varius quam at odio scelerisque at sapien efficitur. venenatis varius vel ullamcorper
            </p>

            <Button
                onClick={handleBack}
                variant="default"
                className="w-full mt-4 py-6"
            >
                {'Volver'}
            </Button>
        </div>
    );
}

export default ContratoConfidencialidad;
