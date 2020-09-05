import { Component } from "react";


interface propsBttn {
    pulsado: boolean
    nombre: string
}

class Boton extends Component<propsBttn, {}> {
    constructor(props: propsBttn) {
        super(props);
        this.state = {
            pulsado: false,
            nombre: props.nombre
        }
    }

    render() {
        return(
            <a href="#">{{ this.state.nombre }}</a>
        )
    }
}