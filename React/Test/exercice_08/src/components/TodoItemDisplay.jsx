const TodoItemDisplay = ({contact, deletecontact, switchcontactStatus}) => {
  return ( 
    <div className="my-2 p-3 border-light rounded">
      <div className="d-flex justify-content-between align-items-center">
        <h5>{contact.Name}</h5>
        <p>{contact.Surname}</p>
      <p>{contact.email}</p>
      </div>
      <hr />
      <div className="d-flex justify-content-between">
        <button className={`btn ${contact.isDone ? 'btn-success' : 'btn-warning'}`} onClick={switchcontactStatus}>
          {contact.isDone ? "Done" : "To Do"}
        </button>
        <button className="btn btn-danger" onClick={deletecontact}>Delete</button>
      </div>
    </div>
   );
}
 
export default TodoItemDisplay;