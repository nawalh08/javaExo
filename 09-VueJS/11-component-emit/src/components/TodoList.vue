<script setup>
import {ref} from 'vue';
import AddTodo from './AddTodo.vue';
import TodoItem from './TodoItem.vue';

let todos = ref([]);
let newLabel= new ref('toto');
console.log(newLabel.value);
const addTodo = newTodoText => {
  todos.value.push({text: newTodoText})
}

const removeTodo = index => {
  todos.value.splice(index,1)
}
function editToDo(index) {
  console.log(index);
  // let toDoToEdit = todos.value.find((item) => item.index === index);
  newLabel.value = prompt("Veuillez entrer le nouvel intitulé")
  console.log(newLabel.value);
  console.log(todos);
  
  todos.value[index].text = newLabel.value

}
</script>

<template>
  

<div>
  <AddTodo @add-todo="addTodo" />
  <h3 v-if="todos.length" class="mt-4"> Liste des tâches : </h3>
  <ul>
    <TodoItem v-for="(todo,index) in todos"
    :key="index"
    :todo="todo"
    :index="index"
    @remove-todo="removeTodo"
    @edit-todo="editToDo"/>
  </ul>

</div>


</template>

<style scoped>

</style>
