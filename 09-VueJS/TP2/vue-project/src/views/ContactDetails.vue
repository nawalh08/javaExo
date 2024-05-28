<script setup>
import { inject } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const {contact} = inject('contacts'); 

const route = useRoute();
const router = useRouter();

let {contactId} = route.params
contactId = Number(contactId)
console.log(contact.value[contactId]);
console.log(contact);
console.log(contactId);
const contactFound = contact.value.find(c => c.id === contactId);
console.log(contactFound);
</script>
<template>
    <h1>{{ contact[contactId].name }}</h1>
    <h2>Name :{{ contact[contactId].name }}</h2>
    <h2>Email :{{ contact[contactId].email }}</h2>
    <h2>Phone : {{ contact[contactId].phone }}</h2>
    <h2>City : {{ contact[contactId].city }}</h2>
    <h2>State : {{ contact[contactId].state }}</h2>
    <h2>Country : {{ contact[contactId].country }}</h2>
    <h2>Organization : {{ contact[contactId].organization }}</h2>
    <h2>Job Profile : {{ contact[contactId].jobProfile }}</h2>
    <h2>Additional Info : {{ contact[contactId].additionalInfo }}</h2>
    <RouterLink :to="`/`">
            <button type="button" class="btn btn-primary">Retour à l'accueil</button>
    </RouterLink>

    
</template>