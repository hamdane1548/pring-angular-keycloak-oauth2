import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-products',
  standalone: false,
  templateUrl: './products.html',
  styleUrl: './products.css',
})
// le role de l'interface de onINit permet de vharge
//les donnes et aussi intiaiser des varibales et lancer une logiauqe
//de dmarage s'abonner a des observables
export class Products implements OnInit{
  public poducts : any;
  constructor(private http : HttpClient) {
  }
   ngOnInit() {
    this.http.get("http://localhost:8087/api/product").subscribe({
      next : data =>{
           this.poducts=data
      },
      error : err => {
        console.log(err)
      }
    })
   }
}
