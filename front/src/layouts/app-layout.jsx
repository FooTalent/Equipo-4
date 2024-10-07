import Navbar from '@/components/shared/navbar';
import Footer from '@/components/shared/footer';

export const AppLayout = ({ children }) => {

  return (
    <>
      <section className='w-full flex flex-col gap-y-4 md:gap-y-0 h-screen'>
        <Navbar />
        {children}
        <Footer />
      </section>
    </>
  );
};
