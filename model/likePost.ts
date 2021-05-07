import { Parent } from './parent';

export class Post {
  idLikePost: number;
  parent: Parent;
  post: Post;
  likesatatus: boolean;
}
