const TodoItemDisplay = ({todo}) => {
  console.log(todo);

  return ( 
    <div className="my-2 p-3 border-light rounded">
      <div className="d-flex justify-content-between align-items-center">
        <h5>{todo.todoTitle}</h5>
  
      </div>
      <hr />
      <p>{todo.todoDescription}</p>
      <div className="d-flex justify-content-between">
        {/* <button className={`btn ${todo.isDone ? 'btn-success' : 'btn-warning'}`} onClick={switchTodoStatus}>
          {todo.isDone ? "Done" : "To Do"}
        </button>
        <button className="btn btn-danger" onClick={deleteTodo}>Delete</button> */}
      </div>
    </div>
   );
}
 
export default TodoItemDisplay;