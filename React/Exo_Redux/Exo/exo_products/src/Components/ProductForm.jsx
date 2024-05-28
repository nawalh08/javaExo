import { useRef } from "react";
import {useDispatch , useSelector} from "react-redux"
import { addProduct } from "./ProductSlice";

const ProductForm = () => {
  const textRef = useRef()
  const PriceRef = useRef()
  const dispatch = useDispatch()
  const products = useSelector(state => state.product.products)

  const handleSubmit = (event) => {
    event.preventDefault()
    dispatch(addProduct({name :textRef.current.value, price : PriceRef.current.value}))
    console.log(products)
    textRef.current.value=""
    PriceRef.current.value=""
  }

  return (  
    <>
      <form onSubmit={handleSubmit}>
        <input type="text" ref={textRef} placeholder="Ajouter une produit"  required/>
        <input type="number" ref={PriceRef} placeholder="Ajouter le prix du produit" required/>
        <button type="sumbit">Valider</button>
      </form>
    </>
  );
}
 
export default ProductForm;