import './assets/main.css'
import { createApp } from 'vue'
import { ref } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import router from './router'

let contact = ref([
    {
        "id": 1,
        "name": "John Smith",
        "email": "jsmith@test.com",
        "phone": "123456789",
        "city": "bangalore",
        "state": "karnataka",
        "country": "India",
        "organization": "Company 1",
        "jobProfile": "Software Developer",
        "additionalInfo": "Ce client a acheté de nombreux produits auparavant et est un client de haute valeur"
    },
    {
        "id": 2,
        "name": "Thomas Pierre",
        "email": "thomas@test.com",
        "phone": "987654321",
        "city": "Lille",
        "state": "Nord",
        "country": "France",
        "organization": "Company 2",
        "jobProfile": "Software Developer",
        "additionalInfo": "Achète des produits rarement."
    },
    {
        "id": 3,
        "name": "Tyrion",
        "email": "tyrion@test.com",
        "phone": "123412345",
        "city": "Porto",
        "state": "Sulo",
        "country": "Portugal",
        "organization": "Company 3",
        "jobProfile": "Software Developer",
        "additionalInfo": "Achète généralement beaucoup de produits."
    }
])
const app = createApp(App);
app.provide("contacts",{
    contact
  });
app.use(router);
app.mount("#app");
