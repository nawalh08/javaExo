import { useDispatch, useSelector } from "react-redux";
import { deleteProduct, updateProduct } from "./ProductSlice";
import { useRef, useState } from "react";

const ProductItem = (props) => {
  const produit = props.product
  // Pour utiliser les fonctions définies dans le slice
  const dispatch = useDispatch()
  const [edit,setEdit]=useState(false)
  const nameRef = useRef("")
  const priceRef = useRef("")
  const products = useSelector(state => state.product.products)

  const handleSubmit = (event) => {
    event.preventDefault()
    console.log(products)
    dispatch(updateProduct({name :nameRef.current.value, price : priceRef.current.value,id:produit.id}))   
    setEdit(!edit)
  
  }

  

  return (  
    <div>
         {edit ? <form onSubmit={handleSubmit}> <input type="text" defaultValue={produit.name} ref={nameRef} required></input><input type="number" defaultValue={produit.price} ref={priceRef} required></input> <button type="submit" >Valider</button> <button onClick={()=> setEdit(!edit)}>Annuler</button></form> :  <div><p>{produit.name} - {produit.price}</p><button onClick={() => dispatch(deleteProduct(produit.id))}>Supprimer</button>
      <button onClick={() => setEdit(!edit)}>Modifier</button> </div> }
      

    </div>
  );
}
 
export default ProductItem;