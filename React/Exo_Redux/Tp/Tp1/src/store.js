import { configureStore } from "@reduxjs/toolkit";
import authSlice from "./components/LogInComponent/authSlice";


export default configureStore({
  reducer: {
    auth: authSlice,
   
  },
});
