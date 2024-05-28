import { useRef, useState } from "react";

const ContactItemForm = ({addContact}) => {
  const nameRef = useRef("")
  const surenameRef = useRef("")
  const emailRef = useRef("")
  const [id,setId] = useState(1)

  const formHandler = (e) => {
    e.preventDefault()
    const newContact = {
      id: id,
      Name: nameRef.current.value,
      Surname: surenameRef.current.value,
      Email: emailRef.current.value,
      isDone: false
    }

    addContact(newContact)
    setId(id+1);

    nameRef.current.value = ""
    surenameRef.current.value = ""
    emailRef.current.value = ""
    
  }

  return (  
    <div className="formSubmitHandler">
      <h3>ContactForm</h3>
      <form onSubmit={formHandler}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">Nom</label>
          <input type="text" className="form-control"  ref={nameRef} required/>
        </div>
        <div className="mb-3">
          <label htmlFor="surname" className="form-label">Prenom</label>
          <input type="text" className="form-control"  ref={surenameRef} required/>
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">Email</label>
          <input type="email" className="form-control" ref={emailRef} required/>
        </div>
        <div className="text-end">
          <button className="btn btn-outline-light">Submit</button>
        </div>
      </form>
    </div>
  );
}
 
export default ContactItemForm;

