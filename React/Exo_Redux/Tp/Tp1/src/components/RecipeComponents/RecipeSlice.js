import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
  name: "recipe",
  initialState: {
    formMode: "",
    recipes: [],
    selectedRecipe: null,
    ingredients: [],
    isLoading: false,
    error: null
  },
  reducers: {
    
  },
});

