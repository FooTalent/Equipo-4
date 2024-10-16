import FamilyCard from "./components/FamilyCard";
import Header from "./components/Header";

function MentoringRequest() {
  return (
    <div
      id="mentoringRequest-container"
      className="w-[100%] min-h-screen bg-[#e6e6e6] flex justify-center items-center"
    >
      <div
        id="mentoringRequest"
        className="w-[668px] pt-[25px] pr-[20px] pb-[25px] pl-[20px]  bg-white rounded-2xl"
      >
        <div className="flex flex-col">
          <Header />
          <FamilyCard />
        </div>
      </div>
    </div>
  );
}

export default MentoringRequest;
