<script setup>
import { useTodoListStore } from '../stores/todo.js'
import { storeToRefs } from "pinia";

const store = useTodoListStore();
// storeToRefs lets todoList keep reactivity:
const { todoList } = storeToRefs(store);
const { toggleCompleted } = store;
const { toggleFavorite } = store;
const {deleteTodo} = store


</script>

<template>
    <header>
        <h1>
            TP Rick & Morty
        </h1>
    </header>
    <div v-for="todo in todoList" :key="todo.id">
        <div :class="{ completed: todo.completed }">{{ todo.item }}
            <span v-if="todo.favorite" @click.stop="toggleFavorite(todo.id)">&#x1F496;</span>
            <span v-else @click.stop="toggleFavorite(todo.id)">&#x1F90D;</span>
            
            <span @click="deleteTodo(todo.id)">&#10060;</span>
        </div>        
        <hr>
    </div>
</template>

<style>
div{
    display : block;
}
.completed {
    text-decoration: line-through;
}
</style>