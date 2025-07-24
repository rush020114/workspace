import React, { useState } from 'react'

const Textarea1 = () => {

  const [intro, setIntro] = useState('')

  return (
    <div>
      <textarea
       cols={50}
       rows={5}
       value={intro}
       onChange={e => setIntro(e.target.value)}
      ></textarea>
    </div>
  )
}

export default Textarea1