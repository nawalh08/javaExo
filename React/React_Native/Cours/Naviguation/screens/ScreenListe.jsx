import { FlatList, StyleSheet, Text, Touchable, TouchableOpacity, View } from 'react-native'
import React, { useState,useEffect } from 'react'
import axios from 'axios'


export default function ScreenListe({navigation}) {
    const [contactlist,Setcontactlist] = useState([])
    useEffect(() => {    
       
            axios.get("https://jsonplaceholder.typicode.com/users")
            .then(response => Setcontactlist(response.data))
            .catch(error => console.log(error))
        
      });
    return (
        <View style={styles.container}>
            <FlatList data={contactlist} renderItem={(itemData) => {
                return (
                    <TouchableOpacity style={styles.contact} onPress={() => navigation.navigate("DetailContact" , {nom : itemData.item.name, pseudo : itemData.item.username, phone : itemData.item.phone, website : itemData.item.website})}>
                        <View >
                            <Text style={styles.text}>{itemData.item.name} </Text>
                        </View>
                    </TouchableOpacity>
                )
            }}
                keyExtractor={(item, index) => {
                    return index;
                }}

            >
            </FlatList>
        </View>
    )
}

const styles = StyleSheet.create({
    container :{
        flex:1,
        backgroundColor:"black",
    },

    contact:{               
        padding:15,
        marginVertical:20,
        marginHorizontal:20,
        backgroundColor:"red",
        justifyContent:'center',
        borderRadius:25,
        textAlign:'center',        
        alignItems:'center'
    },
    text:{
        fontSize:25,
        fontWeight:'bold',
        color : 'white'
    }
})

