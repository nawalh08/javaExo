import React from 'react';
import {View, StyleSheet, Text, TextInput,Button, FlatList} from 'react-native';
import ModalAdd from './ModalAdd';

const ListeCourse = () => {
  const [inputValue, onChangeinputValue] = React.useState('');
  const [ModalShow, onChangeModalShow] = React.useState(false);
  const [tab,setTab] = React.useState([])
  function ShowModal(){
    onChangeModalShow(true)

  }
  function CloseModal(){
    onChangeModalShow(false)

  }
  function addToList(){
    setTab([...tab,inputValue])
    onChangeModalShow(false)
    console.log(tab);
  }
  


  return (
    <View>
      <Text style={styles.title}>
        Liste de courses
      </Text>
      <FlatList data={tab} renderItem={(itemData) => {
        return(
            <View>
                <Text>{itemData.item}</Text>
            </View>
        )
      }}
      keyExtractor={(item,index) => {
        return index;
      }}
      
      >
      
      </FlatList>
      
      <Button style={styles.boutton} title='Ajouter Article' onPress={ShowModal}/>
      <ModalAdd visible={ModalShow}  CloseModal={CloseModal} addToList={addToList} setInputValue={onChangeinputValue}/>
      
    </View>
  );
};

const styles = StyleSheet.create({
  input: {
    height: 40,
    margin: 12,
    borderWidth: 1,
    padding: 10,
  },
  title:{
    textAlign : "center",
    fontWeight:"bold"  
  },
  boutton:{
    flex:1,
   
    alignitems: "center",
    justifycontent: "center"
  }
  
});

export default ListeCourse;