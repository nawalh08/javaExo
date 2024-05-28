import { configureStore } from "@reduxjs/toolkit";
import ProductSlice from "./Components/ProductSlice";

// Ici nous rassemblons toutes les slices

export default configureStore({
  reducer: {
    product: ProductSlice,
    // Possibilité d'importer d'autres reducer
  },
});
