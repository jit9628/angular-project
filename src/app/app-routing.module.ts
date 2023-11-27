import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarcomponentComponent } from './components/navbarcomponent/navbarcomponent.component';

const routes: Routes = [
  { path: 'heroes', component: NavbarcomponentComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
