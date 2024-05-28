// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyCGZMga6qY0MfqIL9pFc8fomX8PlgnGBhI",
  authDomain: "tpfaresdriesredux.firebaseapp.com",
  projectId: "tpfaresdriesredux",
  storageBucket: "tpfaresdriesredux.appspot.com",
  messagingSenderId: "17632679668",
  appId: "1:17632679668:web:ac286ca1a859955144b0a1",
  databaseUrl :"https://tpfaresdriesredux-default-rtdb.europe-west1.firebasedatabase.app/"
};

export const BASE_DB_URL = firebaseConfig.databaseUrl;
export const SIGN_UP_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=${firebaseConfig.apiKey}`
export const SIGN_IN_URL = `https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=${firebaseConfig.apiKey}`


// Initialize Firebase
const app = initializeApp(firebaseConfig);