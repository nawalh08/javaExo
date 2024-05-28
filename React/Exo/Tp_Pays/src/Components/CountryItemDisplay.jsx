


const CountryItemDisplay = ({country}) => {
  console.log(country);

  return ( 
     
         <div class="col-md-4 mb-4">
             <div class="card" style={{ width: '30rem', margin: 'auto', }}>
                 <div class="card-body">
                     <img  class="card-img-top" src={country.flags.png} style={{height: 300, margin: 'auto' }} alt="image personnage" />
                     <h5 class="card-title">{country.translations.fra.official}</h5>
                     <p class="card-text"><span>Region :</span> {country.region}</p>
                     <p class="card-text"><span>Capital :</span> {country.capital}</p>
                     <p class="card-text"><span>Population :</span> {country.population}</p>
                     
                 </div>
             </div>
         </div> 


    
   );
}
 
export default CountryItemDisplay;