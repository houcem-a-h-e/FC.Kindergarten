import { NgModule } from '@angular/core';
import {NbCardModule, NbMenuModule} from '@nebular/theme';

import { ThemeModule } from '../@theme/theme.module';
import { PagesComponent } from './pages.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { ECommerceModule } from './e-commerce/e-commerce.module';
import { PagesRoutingModule } from './pages-routing.module';
import { MiscellaneousModule } from './miscellaneous/miscellaneous.module';
import { ReclamationComponent } from './reclamation/reclamation.component';
import { UserComponent } from './user/user.component';
import { ParentsComponent } from './parents/parents.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AuthentificationComponent } from './authentification/authentification.component';
import { KindergartenComponent } from './kindergarten/kindergarten.component';
import { LogoutComponent } from './logout/logout.component';
import { ProfilComponent } from './profil/profil.component';

@NgModule({
    imports: [
        PagesRoutingModule,
        ThemeModule,
        NbMenuModule,
        DashboardModule,
        ECommerceModule,
        MiscellaneousModule,
        NbCardModule,
        FormsModule,
        ReactiveFormsModule
    ],
  declarations: [
    PagesComponent,
    ReclamationComponent,
    UserComponent,
    ParentsComponent,
    AuthentificationComponent,
    KindergartenComponent,
    LogoutComponent,
    ProfilComponent,
  ],
})
export class PagesModule {
}
