import { useState } from 'react';

export default function Notification({ message, read }) {
  const [isRead, setIsRead] = useState(read);
  const handleRead = () => {
    if (!isRead) {
      setIsRead(!isRead);
    }
  };
  return (
    <>
      <div
        className='relative border-orange-300 py-3 rounded-lg px-4 text-lg border-2 bg-transparent hover:bg-transparent text-black'
      >
        <p>{message}</p>
        <button onClick={handleRead} className='absolute right-2 top-[14.5px]'>
          <img src={`${isRead ? '/common/tick-square.svg' : '/common/read.svg'}`} alt='visto' className='' />
        </button>
      </div>
    </>
  );
}