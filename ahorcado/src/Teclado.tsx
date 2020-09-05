import React, { Component } from 'react';

interface KeyBoardState {
    teclas: string[],

}

export default class Teclado extends Component<{}, KeyBoardState> {

    constructor(props) {
        super(props);
        let letras: string = "Q W E R T Y U I O P A S D F G H J K L Ñ Z X C V B N M"
        this.state = {
            teclas: letras.split(' ')
        }

        console.log(this.state.teclas)
    }

    render() {
        let teclado: React.DetailedHTMLProps<React.AnchorHTMLAttributes<HTMLAnchorElement>, HTMLAnchorElement>
        this.state.teclas.map(function (x:string) {
            teclado += <a href="#">x</a>
        })

        return(
            <div>
                

                
            </div>
            
        )
    }
}