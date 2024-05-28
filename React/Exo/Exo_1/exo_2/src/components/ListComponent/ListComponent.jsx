

const PersonTable = () => {
    const myPersons = [
      {"firstname": "Albert", "lastname": "DUPONT"},
      {"firstname": "Maria", "lastname": "DUPONT"},
      {"firstname": "Chloé", "lastname": "DUPONT"},
      {"firstname": "Sylvia", "lastname": "DUPONT"},
    ]
  
    return ( 
    <div>
      <h1>Mon tableau </h1>
      <table className="table table-dark">
        <thead>
          <tr>
            <th>#</th>
            <th>Firstname</th>
            <th>Lastname</th>
          </tr>
        </thead>
        <tbody>
          {
            myPersons.map((person, index) => (
              <tr key={index}>
                <td>{index+1}</td>
                <td>{person.firstname}</td>
                <td>{person.lastname}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>);
  }
   
  export default PersonTable;