import Navbar from '@/components/shared/navbar';
import Footer from '@/components/shared/footer';

export const AppLayout = ({ children }) => {

  return (
    <>
      <section className='w-full flex flex-col gap-y-4 md:gap-y-6 md:py-8 h-screen max-w-[1750px] mx-auto'>
        <Navbar />
        {children}
        <Footer />
      </section>
    </>
  );
};
