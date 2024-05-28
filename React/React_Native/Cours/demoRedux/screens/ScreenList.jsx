import { Pressable, StyleSheet, Text, View,Linking, TouchableOpacity, ScrollView  } from 'react-native'
import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { removeIds } from '../store/redux/data'
import Form from '../component/Form'

export default function ScreenList({navigation}) {

  const myId = useSelector((state) => state.data.ids)
  const dispatch = useDispatch()

  return (
    <ScrollView style={styles.container}>
      <Text>MyId</Text>
      {myId.map((ids,i) => <Pressable style={styles.contact} key={i} onPress={() => dispatch(removeIds({ id : ids }))}><Text style={styles.text}>{ids}</Text></Pressable>)}
     
      <TouchableOpacity style={styles.contact} onPress={() => navigation.navigate("AddId")}>
                        <View >
                            <Text style={styles.text}>Ajout D'id </Text>
                        </View>
                    </TouchableOpacity>
    </ScrollView>
  )
}

const styles = StyleSheet.create({
  text: {
    fontSize: 32,
    color:'white'
    
  },
  container :{
    flex:1,
    backgroundColor:"black",
    textAlign:'center'
},
contact:{               
    padding:0,
    marginVertical:5,
    marginHorizontal:5,
    backgroundColor:"red",
    justifyContent:'center',
    borderRadius:25,
    textAlign:'center',        
    alignItems:'center'
},
})