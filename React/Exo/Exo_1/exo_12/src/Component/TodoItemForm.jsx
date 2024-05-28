import { useRef } from "react";

const TodoItemForm = ({addTodo}) => {
  const titleRef = useRef("")  
  const descriptionRef = useRef("") 

  const formHandler = (e) => {
    e.preventDefault()
    const newTodo = {
      id: Date.now(),
      title: titleRef.current.value,
      description: descriptionRef.current.value,      
      isDone: false
    }

    addTodo(newTodo)

    titleRef.current.value = ""
    descriptionRef.current.value = ""
   
  }

  return (  
    <div className="formSubmitHandler">
      <h3>TodoForm</h3>
      <form onSubmit={formHandler}>
        <div className="mb-3">
          <label htmlFor="title" className="form-label">Title</label>
          <input type="text" className="form-control"  ref={titleRef} required/>
        </div>
        <div className="mb-3">
          <label htmlFor="description" className="form-label">Description</label>
          <textarea className="form-control" cols={30} rows={10} ref={descriptionRef} required/>
        </div>
        
        <div className="text-end">
          <button className="btn btn-outline-light">Submit</button>
        </div>
      </form>
    </div>
  );
}
 
export default TodoItemForm;