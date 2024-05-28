import { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css'
import ContactItemForm from './components/TodoItemForm';
import ContactItemDisplay from './components/TodoItemDisplay';

function App() {
  const [contact, setContact] = useState([])

  const addContact = (newContact) => {
    setContact([...contact, newContact])
  }

  const deleteContact = (contactId) => {
    setContact([...contact.filter(contact => contact.id != contactId)])
  }

  const switchcontactStatus = (contactId) => {
    const oldcontact = contact.find(contact => contact.id === contactId)
    if(oldcontact) {
      oldcontact.isDone = !oldcontact.isDone
      setContact([...contact.filter(contact => contact.id != contactId), oldcontact])
    }
  }

  https://openlibrary.org/subjects/romance.json?limit=100).

  return (
    <div className='container'>
      <div className='row my-3 g-2'>
        <div className='col-4'>
          <div className='p-3 bg-dark rounded text-light'>
              <ContactItemForm addContact={addContact} />
          </div>
        </div>
        <div className='col-8'>
          <div className='p-3 bg-dark rounded text-light'>
            <h3>Contacts</h3>
            <hr />
            {contact.length === 0 && <p>Il n'y a pas de contact pour le moment</p>}
            {contact.length > 0 && contact.sort((x,y) => x.id - y.id).map((contact, index) => <ContactItemDisplay key={index} deletecontact={() => deleteContact(contact.id)} 
            switchcontactStatus={() => switchcontactStatus(contact.id)} contact={contact} />)}
          </div>
        </div>
      </div>
    </div>
  )
}

export default App
