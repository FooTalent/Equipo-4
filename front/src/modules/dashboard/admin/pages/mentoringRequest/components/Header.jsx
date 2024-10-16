import { Link } from "react-router-dom";
import { SlArrowLeft } from "react-icons/sl";
function Header() {
  return (
    <div id="mentoringRequest-header">
      <div
        id="mentoringRequest-header-container"
        className="flex flex-col w-[100%] h-full"
      >
        <div id="mentoringRequest-header-button" className="flex w-[100%]">
          <Link
            to="/dashboard"
            className="flex justify-start text-black"
            color="white"
            variant="outlined"
            size="large"
          >
            <SlArrowLeft />
          </Link>
        </div>
        <div id="mentoringRequest-header-title">
          <h2 className="text-2xl">Solicitud de Mentorias</h2>
        </div>
      </div>
    </div>
  );
}

export default Header;
