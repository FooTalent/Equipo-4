import { useEffect, useState } from 'react';
import FamilyCard from './components/FamilyCard';
import Header from './components/Header';
import { getAllMentoringApi } from '../../api';
import { AppLayout } from '@/layouts/app-layout';

function MentoringRequest() {
  const [mentoringRequest, setMentoringRequest] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchMentoringRequests = async () => {
      try {
        const response = await getAllMentoringApi();
        setMentoringRequest(response);
      } catch {
        setError('Failed to fetch mentoring requests');
      } finally {
        setLoading(false);
      }
    };

    fetchMentoringRequests();
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <AppLayout>
      <div
        id='mentoringRequest-container'
        className='w-full min-h-screen bg-[#e6e6e6] flex justify-center items-center'
      >
        <div
          id='mentoringRequest'
          className='w-[668px] p-[25px] bg-white rounded-2xl'
        >
          <div className='flex flex-col gap-5'>
            <Header />
            {mentoringRequest.length > 0 ? (
              mentoringRequest.map((mentoring, index) => (
                <FamilyCard key={index} mentoring={mentoring} />
              ))
            ) : (
              <p>No mentoring requests available</p>
            )}
          </div>
        </div>
      </div>
    </AppLayout>
  );
}

export default MentoringRequest;
