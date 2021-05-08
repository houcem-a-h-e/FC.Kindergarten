import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS = [
  {
    title: 'home',
    icon: 'shopping-cart-outline',
    link: '/pages/dashboard',
    home: true,
  },
  {
    title: 'register',
    link: '/pages/register',
  },
  {
    title: 'registerkinder',
    link: '/pages/registerkinder',
  },
  {
    title: 'logout',
    link: '/pages/logout',
  },
  {
    title: 'profil',
    link: '/pages/profil',
  },


  {
    title: 'Auth',
    icon: 'lock-outline',
    children: [
      {
        title: 'Login',
        link: '/pages/login',
      },
      {
        title: 'Registers',
        link: '/auth/register',
      },

      {
        title: 'Request Password',
        link: '/auth/request-password',
      },
      {
        title: 'Reset Password',
        link: '/auth/reset-password',
      },

    ],
  }
];
