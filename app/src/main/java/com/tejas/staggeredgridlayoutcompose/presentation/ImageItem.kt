package com.tejas.staggeredgridlayoutcompose.presentation

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.skydoves.landscapist.rememberDrawablePainter
import com.tejas.staggeredgridlayoutcompose.R
import com.tejas.staggeredgridlayoutcompose.RandomHeightGenerator
import com.tejas.staggeredgridlayoutcompose.datamodel.ImageItem

@Composable
fun ImageItem(
    image: ImageItem,
    context: Context
){
    var data by remember { mutableStateOf(ContextCompat.getDrawable(context, R.drawable.ic_launcher_background)) }

    Glide.with(context)
        .load(image.download_url)
        .placeholder(R.drawable.ic_launcher_background)
        .into(object: CustomTarget<Drawable>(){
            override fun onResourceReady(
                resource: Drawable,
                transition: Transition<in Drawable>?
            ) {
                data = resource
            }
            override fun onLoadCleared(
                placeholder: Drawable?
            ) {
                data = placeholder
            }
        })
    Box(
        modifier = Modifier
            .height(
                RandomHeightGenerator.generate().dp
            )
            .clip(RoundedCornerShape(12.dp))
    ){
        ConstraintLayout(
            modifier = Modifier.fillMaxHeight()
        ) {
            val (background, author, gradient) = createRefs()
            Image(
                painter = rememberDrawablePainter(drawable = data),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .constrainAs(background) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.FillBounds
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
                    .constrainAs(gradient) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )


            Text(
                text = image.author,
                modifier = Modifier
                    .constrainAs(author) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .padding(bottom = 8.dp, start = 8.dp)
                    .fillMaxWidth(),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                textAlign = TextAlign.Left
            )
        }
    }
}