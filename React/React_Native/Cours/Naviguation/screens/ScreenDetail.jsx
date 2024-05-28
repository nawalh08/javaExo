import { Button, StyleSheet, Text, View, Linking, TouchableOpacity } from 'react-native'
import React, { useLayoutEffect } from 'react'
import Icon from 'react-native-vector-icons/Feather';




export default function ScreenDetail({ navigation, route }) {
    const nom = route.params.nom
    const pseudo = route.params.pseudo
    const phone = route.params.phone
    const website = route.params.website
    function handleCallPress() {
        Linking.openURL(`tel:${phone}`)
    }
    function handleWebSitePress() {
        Linking.openURL(`http:${website}`)
    }

    useLayoutEffect(() => {
        navigation.setOptions({ title: nom })
    }, [])
    return (
        <View style={styles.container}>
            <View style={styles.contact}>
                <Text style={styles.text}>{nom}</Text>
                <Text style={styles.text}>{pseudo}</Text>
                <Text style={styles.text}>{phone}</Text>
                <Text style={styles.text} onPress={()=> handleWebSitePress()}>{website}</Text>
            </View>
            <TouchableOpacity style={styles.contact} onPress={() => handleCallPress()}>
                        <View >
                            <Text style={styles.text}><Icon name="phone-call" size={28}/>Appeler le contact </Text>
                        </View>
                    </TouchableOpacity>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "black",
    },

    contact: {
        padding: 15,
        marginVertical: 20,
        marginHorizontal: 20,
        backgroundColor: "red",
        justifyContent: 'center',
        borderRadius: 25,
        textAlign: 'center',
        alignItems: 'center'
    },
    text: {
        fontSize: 25,
        fontWeight: 'bold',
        color: 'white'
    }
})
