<script setup>
import { reactive, ref } from 'vue';
let listeTodo = ref([]);
let listeTodoFilter = ref([])
let filter = ref("All");
class Todo{
  constructor(title) {
    this.title = title;
    this.status = false
  }
}

function todoTerminer(todo){
  if (todo.status === false){
    todo.status = true
  }else{
    todo.status = false;
  }
  console.table(todo.status);
}
function deleteTodo(todo) {
  listeTodo.value = listeTodo.value.filter((x) => x !== todo);
}
function createTodo(titre){
  let todo =new Todo(titre)
  console.log(todo);
  listeTodo.value.push(todo)
  console.table(listeTodo);
  return todo
}
let intitule = ref("");
let checked = ref(false)
</script>

<template>
  <select>
    <option>
      All
    </option>
    <option>
      Finished
    </option>
    <option>
      Not Done
    </option>
  </select>
  <form @submit.prevent="console.log(`${intitule}`)">
    <div>
      <label for="">Intitulé de la to-do</label>
      <input type="text" name="intitule" id="" v-model.lazy="intitule">
    </div>
    <button @click="createTodo(intitule)" type="submit"  >Envoyer le formulaire</button>
  </form>
  <ul id="example-1">
  <li  v-for="todo in listeTodo" :key="todo.id" v-on:remove="listeTodo.splice(index, 1)">
    {{ todo.title }}
    {{ todo.status }}
    <button class="delete" @click="deleteTodo(todo)">Delete</button>
    <input type="checkbox" @click="todoTerminer(todo)">Todo Finie ? 
  </li>
</ul>
</template>

<style scoped>
select{
  height: 50px;
  width:  90px;
}
</style>
