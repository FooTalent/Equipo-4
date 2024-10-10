import Footer from "@/components/shared/footer";
import Navbar from "@/components/shared/navbar";
import React from "react";
export default function HomeFamilies() {
  return (
    <>
      {/*RECORDAR DE BORRAR*/}
      <Navbar />
      {/*RECORDAR DE BORRAR*/}
      <div
        id="home-families-container"
        className="w-full h-screen bg-[#e6e6e6]"
      >
        <div
          id="home-families"
          className="flex items-center justify-center w-full h-full"
        >
          <div id="home-families-content">
            <div
              id="home-families-form"
              className="bg-white rounded-[12px] pt-[20px] pr-[20px] pb-[25px] pl-[20px]"
            >
              <section id="home-families-form-title" className="w-full">
                <h1>Bienvenidos</h1>
              </section>
              <form id="home-families-form"></form>
            </div>
          </div>
        </div>
      </div>
      {/*RECORDAR DE BORRAR*/}
      <Footer />
      {/*RECORDAR DE BORRAR*/}
    </>
  );
}
