import { useEffect, useState } from 'react';
import { getFamilyByIdApi } from '../../../api';

const FamilyCard = ({ mentoring }) => {
  const [family, setFamily] = useState({});

  useEffect(() => {
    if (mentoring.familiaMentoradaId) {
      getFamilyByIdApi(mentoring.familiaMentoradaId)
        .then((response) => {
          setFamily(response);
        })
        .catch((error) => {
          console.error('Error fetching family data:', error);
        });
    }
  }, [mentoring.familiaMentoradaId]);

  return (
    <div
      id='mentoringRequest-family-card'
      className='w-full border-[#FF961A] border-[1px] border-solid rounded-[6px] pl-[16px] pr-[16px] pt-[8px] pb-[8px]'
    >
      <h3>{family.nombreFaUno ? family.nombreFaUno : 'No se dispone de información'}</h3>
    </div>
  );
};

export default FamilyCard;
