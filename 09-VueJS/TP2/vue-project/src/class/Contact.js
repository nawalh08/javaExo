export default class Contact {
 
    
 
    constructor(name, mail,phone,city,state,country,organization,jobprofile,addinfo) 
    {
      this.Name = name;
      this.Mail = mail;
      this.Phone = phone ;
      this.City = city;
      this.State = state;
      this.Country = country;
      this.Organization = organization;
      this.JobProfile = jobprofile;
      this.Addinfo = addinfo;
    }
    getFullName()
    {
      return this.FirstName+' '+ this.LastName;
    }
    getFirstName()
    {
      return this.FirstName;
    }
    getLastName()
    {
      return this.LastName;
    }        
}