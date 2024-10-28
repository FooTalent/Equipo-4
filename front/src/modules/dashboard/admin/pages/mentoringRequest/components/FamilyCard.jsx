const FamilyCard = ({ mentoring }) => {
  return (
    <div
      id='mentoringRequest-family-card'
      className='w-full border-[#FF961A] border-[1px] border-solid rounded-[6px] pl-[16px] pr-[16px] pt-[8px] pb-[8px]'
    >
      <h3>
        {mentoring
          ? mentoring.familiaMentorada.nombre
          : 'No se encuentran solicitudes de mentorias'}
      </h3>
    </div>
  );
};

export default FamilyCard;
