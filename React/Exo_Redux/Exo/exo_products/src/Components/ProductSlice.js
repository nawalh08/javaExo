import { createSlice } from "@reduxjs/toolkit";

// Ici, nous centraliserons et traiterons les différentes données

const ProductSlice = createSlice({
  name: "product",
  initialState: {
    // ici, nous retrouverons nos variables d'état
    products: []   
  },
  reducers: {
    // state : contenu de initialState
    // action : élément envoyé à notre store {type: "task/addTask", payload}
    // payload : est un objet contenant les paramètres de la fonction
    addProduct: (state, action) => {
      const newProduct = {
        name: action.payload.name,
        price : action.payload.price,
        id: Date.now()
      };

      state.products.push(newProduct);
      console.log(state.products);
    },
    deleteProduct: (state, action) => {
      state.products = state.products.filter((product) => product.id !== action.payload);
      state.counterTask -= 1;
    },
    updateProduct: (state, action) => {
      const product = state.products.find((product) => product.id === action.payload.id);
      console.log(product);
      product.name = action.payload.name
      product.price = action.payload.price
    },
   
  },
});

export const { addProduct, deleteProduct,updateProduct  } = ProductSlice.actions;
export default ProductSlice.reducer;